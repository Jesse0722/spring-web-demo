package com.example.demo.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;



/**
 * Created by jesse on 2017/2/13.
 * 实际处理文件
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;//Convenient factory for a JobBuilder which sets the JobRepository automatically.

    @Autowired
    public StepBuilderFactory stepBuilderFactory;//Convenient factory for a StepBuilder which sets the JobRepository and PlatformTransactionManager automatically.

    @Autowired
    public DataSource dataSource;

    /*
        文件读取
     */
    @Bean
    public FlatFileItemReader<Company> reader() {
        FlatFileItemReader<Company> reader = new FlatFileItemReader<Company>();
        reader.setResource(new ClassPathResource(""));
        reader.setLineMapper(new DefaultLineMapper<Company>(){{
            //匿名内部类，在此类中给调用setLineTokenizer和setFieldSetMapper方法给属性赋值，
            //但是setLineTokenizer和setFieldSetMapper方法都传入了的接口，因此需要实现接口中的抽象方法
            setLineTokenizer(new DelimitedLineTokenizer(){
                //使用匿名内部类，必须继承一个父类或者实现一个接口
                //继承父类是可以在匿名类中用{父类方法}来调用父类方法，否则实现这个接口
                //实现接口的抽象方法时时
                //这里DelimitedLineTokenizer继承了AbstractLineTokenizer类，并且调用了其父类的setNames方法
                {
                    setNames(new String[] { "firstName", "lastName" });
                }
            });
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Company>(){
                {
                    setTargetType(Company.class);//调用BeanWrapperFieldSetMapper类的此方法
                }
            });
        }

        });
        return reader;
    }

}
