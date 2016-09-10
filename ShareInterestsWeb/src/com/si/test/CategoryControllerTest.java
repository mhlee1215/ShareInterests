package com.si.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.si.domain.Category;
import com.si.service.CategoryService;
import com.si.web.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/conf/applicationContext.xml",
		"file:WebContent/WEB-INF/SpringEx-servlet.xml",
		// "file:WebContent/WEB-INF/web.xml",
		"classpath:conf/sqlMapConfig.xml" })
@WebAppConfiguration
public class CategoryControllerTest {
	@Autowired
	CategoryService categoryService;

	// @InjectMocks
	// private UserController userController;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		// mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testCategoryController() throws Exception {
		// when(categoryService.findAll()).thenReturn(10);
		// System.out.println("?????: "+categoryService);
		System.out.println(categoryService.findAll());
		// mockMvc.perform(get("/category/list")).andExpect(status().isOk());

		// verify(categoryService).method1();
		// verifyNoMoreInteractions(categoryService);
	}

	@Test
	public void testCategoryCreatedReadDeleteWithEmptyHobbyList() {
		Category category = new Category();

		String testingName = "testing";
		category.setName(testingName);

		categoryService.createCategory(category);
		Assert.assertEquals(testingName, categoryService.readCategory(category).getName());

		categoryService.deleteCategory(category);
		Assert.assertNull(testingName, categoryService.readCategory(category));
	}
}
