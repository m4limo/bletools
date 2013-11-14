package de.grundid.ble.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import android.bluetooth.BluetoothGattCharacteristic;

public class BleUtils {

	private static final Map<Integer, String> PROPERTIES = new LinkedHashMap<Integer, String>();
	static {
		PROPERTIES.put(BluetoothGattCharacteristic.PROPERTY_BROADCAST, "BC");
		PROPERTIES.put(BluetoothGattCharacteristic.PROPERTY_READ, "RD");
		PROPERTIES.put(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, "WN");
		PROPERTIES.put(BluetoothGattCharacteristic.PROPERTY_WRITE, "WR");
		PROPERTIES.put(BluetoothGattCharacteristic.PROPERTY_NOTIFY, "NY");
		PROPERTIES.put(BluetoothGattCharacteristic.PROPERTY_INDICATE, "IN");
		PROPERTIES.put(BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE, "SW");
		PROPERTIES.put(BluetoothGattCharacteristic.PROPERTY_EXTENDED_PROPS, "EP");
	}

	public static String createPropertiesField(int flag) {
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, String> entry : PROPERTIES.entrySet()) {
			int flagBit = entry.getKey().intValue();
			if ((flag & flagBit) == flagBit) {
				sb.append(entry.getValue());
			}
			else {
				sb.append("--");
			}
		}
		return sb.toString();
	}
}
