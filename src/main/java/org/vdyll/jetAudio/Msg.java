package org.vdyll.jetAudio;

import org.vdyll.utils.jna.User32;

public class Msg {

    public final static int msgGetStatus            = User32.W_APP + 740;
    public final static int msgSendCommand          = User32.W_APP + 741;
    public final static int msgWM_COPYDATA          = 0x004A;
    public final static int msgWM_COPYDATA_FILENAME = 0x3000;
    public final static int msgWM_COPYDATA_TITLE    = 0x3001;
    public final static int msgWM_COPYDATA_ARTIST   = 0x3002;
}
