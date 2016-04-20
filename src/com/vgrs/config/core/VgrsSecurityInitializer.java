package com.vgrs.config.core;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class VgrsSecurityInitializer extends
		AbstractSecurityWebApplicationInitializer {
	public VgrsSecurityInitializer() {
		super(SecurityConfig.class);
	}
}