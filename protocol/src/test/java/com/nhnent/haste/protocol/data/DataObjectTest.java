/*
* Copyright 2016 NHN Entertainment Corp.
*
* NHN Entertainment Corp. licenses this file to you under the Apache License,
* version 2.0 (the "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at:
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.nhnent.haste.protocol.data;

import org.junit.Assert;
import org.junit.Test;

public class DataObjectTest {
    // Generated by client-side.
    byte[] aByte = new byte[]{0, 0, 0, 1, 0, 1, 119}; // 119
    byte[] aBool = new byte[]{0, 0, 0, 1, 0, 2, 0}; // false
    byte[] aShort = new byte[]{0, 0, 0, 1, 0, 3, 68, 25}; // 17433
    byte[] aInt = new byte[]{0, 0, 0, 1, 0, 4, 3, (byte) 212, 81, 115}; // 64246131
    byte[] aLong = new byte[]{0, 0, 0, 1, 0, 5, 0, 0, 42, 15, (byte) 151, (byte) 228, (byte) 137, (byte) 229}; // 46246461213157
    byte[] aFloat = new byte[]{0, 0, 0, 1, 0, 6, 67, (byte) 183, 31, 59}; // 366.244F
    byte[] aDouble = new byte[]{0, 0, 0, 1, 0, 7, 64, 95, 91, (byte) 236, (byte) 148, 18, 113, 28}; // 125.4363146
    byte[] aString = new byte[]{0, 0, 0, 1, 0, 8, 0, 0, 0, 14, 84, 104, 105, 115, 32, 105, 115, 32, 116, 101, 115, 116, 33, 33}; // "This is test!!"

    private void GeneralTest(byte[] datas, byte key, Object expect) {
        DataObject object = DataObject.toDataObject(datas);
        Object value = object.get(key).value;
        Assert.assertEquals(expect, value);
    }

    @Test
    public void SerializeTest() {
        GeneralTest(aByte, (byte) 0, (byte) 119);
        GeneralTest(aBool, (byte) 0, false);
        GeneralTest(aShort, (byte) 0, (short) 17433);
        GeneralTest(aInt, (byte) 0, 64246131);
        GeneralTest(aLong, (byte) 0, 46246461213157L);
        GeneralTest(aFloat, (byte) 0, 366.244F);
        GeneralTest(aDouble, (byte) 0, 125.4363146);
        GeneralTest(aString, (byte) 0, "This is test!!");
    }
}