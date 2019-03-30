//                   ::::::::
//         :+:      :+:    :+:
//    +++++++++++  +:+         +++++
//       +:+      +#+         +#  +#
//      +#+      +#+         +#
//     #+#      #+#     +#  +#  +#
//    ###       ########+   ####+

package org.vdyll.jetAudio;

/**
 * ENUM representing all the actions which this API currently exposes.
 * 
 * @author MC_Crafty
 *
 */
public enum Action {
    togglePlayPause("Toggle Play Pause", "togglePlayPause"),
    stop("Stop", "stop"),
    nextTrack("Next Track", "nextTrack"),
    prevTrack("Previous Track", "prevTrack"),
    toggleMute("Toggle Mute", "toggleMute"),
    volUp("Volume Up", "volUp"),
    volDown("Volume Down", "volDown");

    /**
     * Human readable and UI friendly name for the action
     */
    private final String name;
    /**
     * The method name in the main controller {@link JetAudioJavaAPI} which this action will call
     */
    private final String callback;

    Action(final String name, final String callback) {
        this.name = name;
        this.callback = callback;
    }

    public String getName() {
        return this.name;
    }

    public String getCallback() {
        return this.callback;
    }
}
