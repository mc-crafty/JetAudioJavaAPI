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
 * API Exposing the control features of the Jet Audio Remote Control plug-in
 *
 * @author MC_Crafty
 *
 */
public class Ctrl {

    public final static int msgSendCommand  = User32.W_APP + 741;

    public final static int playPause       = 5104;
    public final static int ctrlStop        = 5102;
    public final static int ctrlNextTrack   = 5108;
    public final static int ctrlPrevTrack   = 5107;
    public final static int ctrlSetVol      = 5180;
    public final static int ctrlToggleMute  = 5172;

    public final static int volMax          = 100;
    public final static int volMin          = 0;
    public final static int volChangeAmount = 10;

    public final static int ctrlParamPlayPause(final int trackNum) {
        return User32.makeLParam(playPause, trackNum);
    }

    public final static int ctrlParamVolUp(final int curVol) {
        return User32.makeLParam(ctrlSetVol, Math.min(volMax, curVol + volChangeAmount));
    }

    public final static int ctrlParamVolDown(final int curVol) {
        return User32.makeLParam(ctrlSetVol, Math.max(volMin, curVol - volChangeAmount));
    }

    public final static int ctrlPlayPauseCurrentTrack(final HWND hWnd) {
        return User32.INSTANCE.SendMessageA(hWnd, msgSendCommand, 0, Ctrl.ctrlParamPlayPause(0));
    }

    public final static int ctrlPlayPause(final HWND hWnd, final int trackNum) {
        return User32.INSTANCE.SendMessageA(hWnd, msgSendCommand, 0, Ctrl.ctrlParamPlayPause(trackNum));
    }

    public final static int ctrlStop(final HWND hWnd) {
        return User32.INSTANCE.SendMessageA(hWnd, msgSendCommand, 0, Ctrl.ctrlStop);
    }

    public final static int ctrlNextTrack(final HWND hWnd) {
        return User32.INSTANCE.SendMessageA(hWnd, msgSendCommand, 0, Ctrl.ctrlNextTrack);
    }

    public final static int ctrlPrevTrack(final HWND hWnd) {
        return User32.INSTANCE.SendMessageA(hWnd, msgSendCommand, 0, Ctrl.ctrlPrevTrack);
    }

    public final static int ctrlToggleMute(final HWND hWnd) {
        return User32.INSTANCE.SendMessageA(hWnd, msgSendCommand, 0, Ctrl.ctrlToggleMute);
    }

    public final static int ctrlVolUp(final HWND hWnd, final int curVol) {
        return User32.INSTANCE.SendMessageA(hWnd, msgSendCommand, 0, Ctrl.ctrlParamVolUp(curVol));
    }

    public final static int ctrlVolDown(final HWND hWnd, final int curVol) {
        return User32.INSTANCE.SendMessageA(hWnd, msgSendCommand, 0, Ctrl.ctrlParamVolDown(curVol));
    }
}
