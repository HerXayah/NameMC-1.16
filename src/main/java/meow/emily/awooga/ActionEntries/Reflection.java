package meow.emily.awooga.ActionEntries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

// Stolen from HDSkins Addon because this is just cancer to add honestly...

public final class Reflection {

    private static final Field MODIFIERS_FIELD;

    private Reflection() {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public static Field getFieldByNames(@Nonnull Class<?> clazz, @Nonnull String... fieldNames) {
        String[] var2 = fieldNames;
        int var3 = fieldNames.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String fieldName = var2[var4];
            Field field = getFieldByName(clazz, fieldName);
            if (field != null) {
                return field;
            }
        }

        return null;
    }

    @Nullable
    public static Field getFieldByName(@Nonnull Class<?> clazz, @Nonnull String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            return field;
        } catch (NoSuchFieldException var3) {
            return null;
        }
    }

    public static void set(@Nonnull Class<?> source, @Nonnull Object instance, @Nullable Object newValue, @Nonnull String... fieldNames) {
        Field field = getFieldByNames(source, fieldNames);
        if (field != null) {
            set(instance, newValue, field);
        }

    }

    public static void set(@Nonnull Object instance, @Nullable Object newValue, @Nonnull Field field) {
        try {
            if (MODIFIERS_FIELD != null && Modifier.isFinal(field.getModifiers())) {
                MODIFIERS_FIELD.setInt(field, field.getModifiers() & -17);
            }

            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            field.set(instance, newValue);
        } catch (IllegalAccessException var4) {
            var4.printStackTrace();
        }

    }

    @Nullable
    public static <T> T get(@Nonnull Class<T> unused, @Nonnull Class<?> source, @Nonnull Object instance, @Nonnull String... fieldNames) {
        String[] var4 = fieldNames;
        int var5 = fieldNames.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String fieldName = var4[var6];
            Field field = getFieldByName(source, fieldName);
            if (field != null) {
                return get(unused, field, instance);
            }
        }

        return null;
    }

    @Nullable
    public static <T> T get(@Nonnull Class<T> unused, @Nonnull Field field, @Nonnull Object instance) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            return (T) field.get(instance);
        } catch (IllegalAccessException var4) {
            return null;
        }
    }

    static {
        try {
            MODIFIERS_FIELD = Field.class.getDeclaredField("modifiers");
            MODIFIERS_FIELD.setAccessible(true);
        } catch (NoSuchFieldException var1) {
            throw new RuntimeException(var1);
        }
    }
}
