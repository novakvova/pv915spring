package com.example.shop.web;

import com.example.shop.entities.Badge;
import com.example.shop.repositories.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.HibernateSessionFactoryUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/badges/")
public class BadgeController {
    private final BadgeRepository regionRepository;

    @GetMapping("/all")
    public double getById(int page, int count) {

        Sort sort = Sort.by("Id");
        long time = System.nanoTime();

        Pageable pageable = PageRequest.of(page,count,sort);
        Page<Badge> list = regionRepository.findAll(pageable);

        SessionFactory sessionFactory =null;
        Session session = null;
        Transaction tx=null;
        try {
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx=session.beginTransaction();
            for (Badge badge: list.getContent()) {
                session.save(badge);
            }
            tx.commit();

        }catch(Exception ex) {
            System.out.println("Exception "+ ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (!sessionFactory.isClosed())
            {
                System.out.println("Closing SessionFactory");
                //sessionFactory.close();
            }
        }
        long result = System.nanoTime() - time;
        double second=result/1000000000.0;
        System.out.println((System.nanoTime() - time) + "ns per million");
        System.out.println(second+ "seconds");
        //pageable = PageRequest.of(0,10,sort);
        return second; //regionRepository.findAll(pageable);
    }
}

