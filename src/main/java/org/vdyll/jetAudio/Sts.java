//                   ::::::::
//         :+:      :+:    :+:
//    +++++++++++  +:+         +++++
//       +:+      +#+         +#  +#
//      +#+      +#+         +#
//     #+#      #+#     +#  +#  +#
//    ###       ########+   ####+

package org.vdyll.jetAudio;

import org.vdyll.utils.jna.User32;

import com.sun.jna.platform.win32.WinDef.HWND;

/**
 * API exposing the status reporting features of the Jet Audio Remote Control
 * plug-in
 *
 * @author MC_Crafty
 *
 */
public class Sts {

    public final static int msgGetStatus            = User32.W_APP + 740;

    public final static int msgWM_COPYDATA          = 0x004A;
    public final static int msgWM_COPYDATA_FILENAME = 0x3000;
    public final static int msgWM_COPYDATA_TITLE    = 0x3001;
    public final static int msgWM_COPYDATA_ARTIST   = 0x3002;

    public final static int stsVol                  = 127;
    public final static int stsMute                 = 110;
    public final static int stsPlayPauseStop        = 1;
    public final static int stsPlay                 = 526;
    public final static int stsPause                = 529;
    public final static int stsStop                 = 525;
    public final static int stsFileName             = 11;
    public final static int stsTitle                = 12;
    public final static int stsArtist               = 13;

    public final static int stsCurVol(final HWND hWnd) {
        return User32.INSTANCE.SendMessageA(hWnd, msgGetStatus, 0, stsVol);
    }

    public final static int stsCurMute(final HWND hWnd) {
        return User32.INSTANCE.SendMessageA(hWnd, msgGetStatus, 0, stsMute);
    }

    public final static int stsCurPlayPauseStop(final HWND hWnd) {
        return User32.INSTANCE.SendMessageA(hWnd, msgGetStatus, 0, stsPlayPauseStop);
    }
}
