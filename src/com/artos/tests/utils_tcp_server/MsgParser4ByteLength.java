package com.artos.tests.utils_tcp_server;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.artos.interfaces.ConnectableMessageParser;
import com.artos.utils.Transform;

public class MsgParser4ByteLength implements ConnectableMessageParser {

	Transform _transform = new Transform();
	byte[] leftOverBytes = null;
	List<byte[]> msgList = null;

	@Override
	public List<byte[]> parse(byte[] data) {

		// reset variable before use
		msgList = new ArrayList<>();
		leftOverBytes = null;

		deserializeMsg(data);

		return msgList;
	}

	private void deserializeMsg(byte[] data) {
		// Check if at least length can be worked outF
		if (!sufficientDataForLengthCalc(data)) {
			leftOverBytes = data;
			return;
		}

		// Check if message can be constructed
		if (!sufficientDataForMsg(data)) {
			leftOverBytes = data;
			return;
		}

		byte[] leftOvers = extractMsg(data);
		if (null != leftOvers) {
			deserializeMsg(leftOvers);
		}
	}

	private byte[] extractMsg(byte[] data) {
		int length = _transform.bytesToInteger(Arrays.copyOfRange(data, 0, 4), ByteOrder.BIG_ENDIAN);
		msgList.add(Arrays.copyOfRange(data, 0, 4 + length));
		if (data.length > 4 + length) {
			return Arrays.copyOfRange(data, 4 + length, data.length);
		}
		return null;
	}

	private boolean sufficientDataForLengthCalc(byte[] data) {
		if (data.length < 4) {
			return false;
		}
		return true;
	}

	private boolean sufficientDataForMsg(byte[] data) {
		int length = _transform.bytesToInteger(Arrays.copyOfRange(data, 0, 4), ByteOrder.BIG_ENDIAN);
		if (data.length < 4 + length) {
			return false;
		}
		return true;
	}

	@Override
	public byte[] getLeftOverBytes() {
		return leftOverBytes;
	}

}
