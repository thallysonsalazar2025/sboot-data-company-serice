package br.com.client.companyregistry.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private final Api api = new Api();
    private final Registry registry = new Registry();

    public Api getApi() {
        return api;
    }

    public Registry getRegistry() {
        return registry;
    }

    public static class Api {
        private String companyRegistryPath;

        public String getCompanyRegistryPath() {
            return companyRegistryPath;
        }

        public void setCompanyRegistryPath(String companyRegistryPath) {
            this.companyRegistryPath = companyRegistryPath;
        }
    }

    public static class Registry {
        private String keySeparator;

        public String getKeySeparator() {
            return keySeparator;
        }

        public void setKeySeparator(String keySeparator) {
            this.keySeparator = keySeparator;
        }
    }
}
