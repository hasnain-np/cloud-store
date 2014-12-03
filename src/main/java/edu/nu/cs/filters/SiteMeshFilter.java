package edu.nu.cs.filters;


import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * Created by Hasnain on 12/2/14.
 */
public class SiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        // Map default decorator. This shall be applied to all paths if no other paths match.
        builder.addDecoratorPath("/*", "/decorators/default-decorator.jsp")
//                .addDecoratorPath("/secure/*", "/decorators/secure-decorator.jsp")
                .addExcludedPath("*ajax*");
    }
}
