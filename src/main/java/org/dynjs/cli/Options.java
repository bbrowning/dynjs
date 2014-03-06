package org.dynjs.cli;

import com.headius.options.Option;
import org.dynjs.Config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Options {
    public static final String PREFIX = "dynjs";
    public static final Option<Config.CompileMode> CLI_COMPILE_MODE = Option.enumeration(PREFIX, "compile.mode", Category.COMPILER, Config.CompileMode.JIT, "Set compile mode: OFF = no compilation (interpreted); JIT = at runtime; FORCE = before execution");
    public static final Option<Boolean> INVOKEDYNAMIC = Option.bool(PREFIX, "invokedynamic.enabled", Category.INVOKEDYNAMIC, true, "Enable invokedynamic support");
    public static final Option<Boolean> COMPATIBILITY_RHINO = Option.bool(PREFIX, "compat.rhino.enabled", Category.COMPATIBILITY, true, "Enable Mozilla Rhino compatibility extensions");
    public static final Option<Boolean> COMPATIBILITY_COMMONJS = Option.bool(PREFIX, "compat.commonjs.enabled", Category.COMPATIBILITY, true, "Enable commonjs compatibility extensions");

    public static enum Category {
        COMPILER("compiler"),
        COMPATIBILITY("compatibility"),
        INVOKEDYNAMIC("invokedynamic");

        private final String desc;

        Category(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return desc;
        }

        public String desc() {
            return desc;
        }
    }

    public static final Collection<Option> PROPERTIES = Collections.unmodifiableCollection(Arrays.<Option>asList(CLI_COMPILE_MODE, INVOKEDYNAMIC, COMPATIBILITY_RHINO, COMPATIBILITY_COMMONJS));
}
