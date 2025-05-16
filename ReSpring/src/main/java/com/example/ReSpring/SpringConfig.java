package com.example.ReSpring;

import com.example.ReSpring.aop.TimeTraceAop;
import com.example.ReSpring.repository.JdbcMemberRepository;
import com.example.ReSpring.repository.JpaMemberRepository;
import com.example.ReSpring.repository.MemberRepository;
import com.example.ReSpring.repository.MemoryMemberRepository;
import com.example.ReSpring.service.MemberService;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
     */

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
/*
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }
     */
}
