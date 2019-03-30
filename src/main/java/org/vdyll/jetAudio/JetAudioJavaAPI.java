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
 * Primary driver for interacting with the exposed APIs for controlling Jet
 * Audio through its Remote Control plug-in. Java enabled through JNA accessing
 * the Window Handle of Jet Audio and using the Remote Control plug-in Windows
 * Messaging code.
 *
 * @author MC_Crafty
 *
 */
public class JetAudioJavaAPI {
    private static HWND    ja      = User32.INSTANCE.FindWindowA("COWON Jet-Audio Remocon Class",
            "Jet-Audio Remote Control");
    private static boolean foundJA = ja != null;

    /**
     * Default constructor. Will obtain the Window Handle to Jet Audio Remote
     * Control plug-in
     */
    public JetAudioJavaAPI() {
        findJA();
    }

    /**
     * If this is false, we can not obtain the Window Handle and should throw an
     * error in the consumer.
     *
     * @return boolean if the Window Handle for Jet Audio Remote Control plug-in
     *         has been obtained
     */
    public boolean hasFoundJA() {
        return foundJA;
    }

    /**
     * Obtain the Window Handle for Jet Audio Remote Control plug-in
     *
     * @return true if handle was obtained
     */
    public boolean findJA() {
        ja = User32.INSTANCE.FindWindowA("COWON Jet-Audio Remocon Class", "Jet-Audio Remote Control");
        return foundJA = ja != null;
    }

    /**
     * Toggle between Play and Pause on the current selected track.
     *
     * @return Status int
     */
    public int togglePlayPause() {
        return Ctrl.ctrlPlayPauseCurrentTrack(ja);
    }

    /**
     * Stop the current selected track.
     *
     * @return Status int
     */
    public int stop() {
        return Ctrl.ctrlStop(ja);
    }

    /**
     * Skip to next track.
     *
     * @return Status int
     */
    public int nextTrack() {
        return Ctrl.ctrlNextTrack(ja);
    }

    /**
     * Revert to previous track.
     *
     * @return Status int
     */
    public int prevTrack() {
        return Ctrl.ctrlPrevTrack(ja);
    }

    /**
     * Toggle between muted and un-muted.
     *
     * @return Status int
     */
    public boolean toggleMute() {
        return Ctrl.ctrlToggleMute(ja) != 0;
    }

    /**
     * Increase the current volume by {@link Ctrl.volChangeAmount}.
     *
     * @return Status int
     */
    public int volUp() {
        return Ctrl.ctrlVolUp(ja, Sts.stsCurVol(ja));
    }

    /**
     * Decrease the current volume by {@link Ctrl.volChangeAmount}.
     *
     * @return Status int
     */
    public int volDown() {
        return Ctrl.ctrlVolDown(ja, Sts.stsCurVol(ja));
    }

    /**
     * Get the current volume.
     *
     * @return Status int
     */
    public int curVol() {
        return Sts.stsCurVol(ja);
    }

    /**
     * Get the play state of the current track; playing, paused, or stopped.
     *
     * @return Status int
     */
    public int curPlayPauseStop() {
        return Sts.stsCurPlayPauseStop(ja);
    }

    /**
     * Get the current state of the mute toggle.
     *
     * @return Status int
     */
    public boolean curMute() {
        return Sts.stsCurMute(ja) != 0;
    }
}
