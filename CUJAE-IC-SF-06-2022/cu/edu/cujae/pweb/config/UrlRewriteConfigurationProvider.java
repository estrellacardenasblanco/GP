package cu.edu.cujae.pweb.config;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

@RewriteConfiguration
public class UrlRewriteConfigurationProvider extends HttpConfigurationProvider {

    @Override
    public Configuration getConfiguration(ServletContext context) {
        return ConfigurationBuilder.begin()
                
        		.addRule(Join.path("/security-users").to("/pages/security/users/user-list.jsf"))
        		.addRule(Join.path("/security-image").to("/pages/security/image/image-list.jsf"))
        		.addRule(Join.path("/welcome").to("/pages/welcome/welcome.jsf"))
        		.addRule(Join.path("/security-question").to("/pages/security/security-question.jsf"))
        		.addRule(Join.path("/login").to("/pages/security/login.jsf"))
        		.addRule(Join.path("/about").to("/pages/welcome/about.jsf"))
        		.addRule(Join.path("/password").to("/pages/security/password/password.jsf"))
        		.addRule(Join.path("/reports-1").to("/pages/reports/report1-list.jsf"))
        		.addRule(Join.path("/reports-2").to("/pages/reports/report2-list.jsf"))
        		.addRule(Join.path("/reports-3").to("/pages/reports/report3-list.jsf"))
        		.addRule(Join.path("/reports-4").to("/pages/reports/report4-list.jsf"))
        		.addRule(Join.path("/reports-5").to("/pages/reports/report5-list.jsf"))
        		.addRule(Join.path("/").to("/pages/security/login.jsf"));
    }

    @Override
    public int priority() {
        return 0;
    }

}
