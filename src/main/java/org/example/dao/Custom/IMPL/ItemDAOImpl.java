package org.example.dao.Custom.IMPL;

import config.FactoryConfiguration;
import org.example.dao.Custom.ItemDAO;
import org.example.entity.ItemEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public void save(ItemEntity Entity) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(Entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(ItemEntity entity) {

    }

    @Override
    public void update(ItemEntity entity) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public ItemEntity search(String id) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        ItemEntity i = session.get(ItemEntity.class, id);

        transaction.commit();
        session.close();

        return i;
    }

    @Override
    public void deletebyid(String code) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM itementity WHERE code = :code").setParameter("code", code)
                .executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public List<String> getid() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<String> query = session.createQuery("select code from ItemEntity ", String.class);
        List<String> clist = query.list();
        session.close();

        return clist;    }

    @Override
    public ItemEntity getdata(String value) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query<ItemEntity> query = session.createQuery("from ItemEntity where code =:id ").setParameter("id",value);
        ItemEntity item = query.getSingleResult();
        session.close();

        return item;
    }

    @Override
    public boolean updatedata(ItemEntity item, Session session) {
        boolean issaved = false;
        try{
            ItemEntity itemEntity = new ItemEntity();
            session.update(item);
            /*transaction.commit();*/
            issaved=true;
        }catch (Exception e){
            System.out.println("update wade aul");
        }
       return issaved;
    }
}
