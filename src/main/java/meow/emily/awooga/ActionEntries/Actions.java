package meow.emily.awooga.ActionEntries;

import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import net.labymod.main.LabyMod;
import net.labymod.user.gui.UserActionGui;
import net.labymod.user.util.UserActionEntry;

// Stolen from HDSkins Addon because this is just cancer to add honestly...

@ParametersAreNonnullByDefault
public final class Actions {

        private static final List<UserActionEntry> REGISTERED_USER_ACTION_ENTRIES = (List) Reflection.get(List.class, UserActionGui.class, LabyMod.getInstance().getUserManager().getUserActionGui(), new String[]{"defaultEntries"});

        private void ActionInvoker() {
            throw new UnsupportedOperationException();
        }

        public static void addUserActionEntry(UserActionEntry userActionEntry) {
            REGISTERED_USER_ACTION_ENTRIES.add(userActionEntry);
        }

        public static void unregisterMarkedEntries() {
            REGISTERED_USER_ACTION_ENTRIES.removeIf((entry) -> {
                return entry instanceof MarkedUserActionEntry;
            });
        }
    }
