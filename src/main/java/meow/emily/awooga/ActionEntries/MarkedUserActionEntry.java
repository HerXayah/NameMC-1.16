package meow.emily.awooga.ActionEntries;

import net.labymod.user.util.UserActionEntry;

// Stolen from HDSkins Addon because this is just cancer to add honestly...

    public abstract class MarkedUserActionEntry extends UserActionEntry {
        public MarkedUserActionEntry(String displayName, UserActionEntry.EnumActionType type, String value, UserActionEntry.ActionExecutor executor) {
            super(displayName, type, value, executor);
        }
    }

