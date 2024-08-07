package application;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "myconfig.app")
@Validated
public class MyConfigProperties {
    @NotBlank
    private String application_Name;
    @NotBlank
    private String version;
    @NotBlank
    private String url;
    private String server_Name;
    private User user = new User();
    private Coverage coverage;

    public String getApplication_Name() {
        return application_Name;
    }

    public void setApplication_Name(String application_Name) {
        this.application_Name = application_Name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServer_Name() {
        return server_Name;
    }

    public void setServer_Name(String server_Name) {
        this.server_Name = server_Name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }

    public static class Coverage{
        List<String> countries = new ArrayList<>();

        public Coverage(List<String> countries) {
            this.countries = countries;
        }

        public Coverage() {
        }

        public List<String> getCountries() {
            return countries;
        }

        public void setCountries(List<String> countries) {
            this.countries = countries;
        }
    }

    public MyConfigProperties() {
    }

    public MyConfigProperties(String application_Name, String version, String url, String server_Name, User user, Coverage coverage) {
        this.application_Name = application_Name;
        this.version = version;
        this.url = url;
        this.server_Name = server_Name;
        this.user = user;
        this.coverage = coverage;
    }


    public class User{
        private String first_name;
        private String last_name;
        @NotBlank
        @Size(max = 15, min = 8)
        private String user_name;
        @NotBlank
        @Size(max = 15, min = 8)
        private String password;

        public User() {
        }

        public User(String first_name, String last_name, String user_name, String password) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.user_name = user_name;
            this.password = password;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}