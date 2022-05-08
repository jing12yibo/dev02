package com.fc.test;

import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafTest {
    @Test
    public void testRenderStaticData() {
        //创建一个模板引擎对象
        //万物皆对象，使用TemplateEngine对象完成后续的操作
        TemplateEngine engine = new TemplateEngine();

        //准备一个模板
        //th：value是模板引擎所支持的标签属性
        //能够被thymeleaf所识别
        String template = "<input type='test' th:value='易烊千玺'>";

        //准备一个环境上下文对象，给模板引擎提供一个可运行的环境
        Context context = new Context();

        //使用模板引擎去处理模板（渲染）
        //获取处理好（渲染好）的页面
        String html = engine.process(template, context);

        System.out.println(html);
    }

    //测试渲染动态数据
    @Test
    public void testRenderDynamicData() {
        //创建一个模板引擎的对象
        TemplateEngine engine = new TemplateEngine();

        String template = "<input type='text' th:value='${name}'>";

        //创建一个环境对象
        //就类似jsp中的ServletContext
        Context context = new Context();

        //设置占位符所对应的参数
        //当作成域对象.setAttribute(key,value)
        context.setVariable("name", "易烊千玺");

        //渲染模板，获取到html
        String html = engine.process(template, context);

        System.out.println(html);
    }

    //直接渲染一个html页面
    @Test
    public void testRenderHtml() {
        //创建一个模板引擎对象
        TemplateEngine engine = new TemplateEngine();

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();

        //给引擎设置解析器
        engine.setTemplateResolver(resolver);

        Context context = new Context();

        context.setVariable("name", "唔西乌西");

        //直接传递一个路径和环境对象就行了
        String html = engine.process("index.html", context);

        System.out.println(html);
    }

    //如果我们又很多公共的前后缀时可以通过这种方式来手动设置前后缀
    @Test
    public void testPrefixAndSuffix() {
        //创建一个模板引擎对象
        TemplateEngine engine = new TemplateEngine();

        //准备一个解析器用来解析html
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();

        //设置前后缀
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");

        //给模板引擎设置解析器
        engine.setTemplateResolver(resolver);

        Context context = new Context();

        context.setVariable("name", "鱼香肉丝");

        //获取渲染后的html页面
        //因为我们手动设置了前后缀，所以只需要使用文件名即可
        String html = engine.process("main", context);

        System.out.println(html);
    }
}
