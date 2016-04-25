package com.vgrs.config.core;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.vgrs.config.SpringSecurityConfig;

public class VgrsSecurityInitializer extends
		AbstractSecurityWebApplicationInitializer {
	public VgrsSecurityInitializer() {
		super(SpringSecurityConfig.class);
	}
}