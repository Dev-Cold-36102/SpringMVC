package com.codegym.repositories;

import com.codegym.models.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class BlogHibernateJPARepository implements IBlogRepository  {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Blog> getAllBlog() {
        String query="SELECT S FROM Blog S";
        return this.entityManager.createQuery(query,Blog.class).getResultList();
    }

    @Override
    public Blog addBlog(Blog blog) {
        if (blog.getId()!=null && blog.getId()>0){
            this.entityManager.merge(blog);
        } else {
            this.entityManager.persist(blog);
        }
        return blog;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        String query="DELETE FROM Blog WHERE id= :idBlog";
        TypedQuery<Blog> typedQuery=this.entityManager.createQuery(query,Blog.class);
        typedQuery.setParameter("idBlog", blog.getId());

        return addBlog(blog);
    }
}
