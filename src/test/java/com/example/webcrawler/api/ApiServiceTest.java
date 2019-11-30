///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.example.webcrawler.api;
//
//import com.example.webcrawler.models.Model;
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Redi
// */
//public class ApiServiceTest {
//    
//    public ApiServiceTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getGooglePosts method, of class ApiService.
//     */
//    @Test
//    public void testGetGooglePosts() throws Exception {
//        System.out.println("getGooglePosts");
//        String url = "https://www.google.com/search?q=test&num=1";
//        ApiService instance = new ApiService();
//        ArrayList<Model> expResult = null;
//        ArrayList<Model> result = instance.getGooglePosts(url);
//        assertEquals(1, result.size());
//
//    }
//    
//}
