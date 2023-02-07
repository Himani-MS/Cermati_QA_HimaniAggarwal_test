
package factory;

import factory.frameworkconfig;
import org.aeonbits.owner.ConfigCache;

public class configfactory {

    private configfactory() {
    }

    public static frameworkconfig getConfig() {
        return ConfigCache.getOrCreate(frameworkconfig.class);
    }
}
