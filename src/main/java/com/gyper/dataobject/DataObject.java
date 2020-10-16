package com.gyper.dataobject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static com.gyper.utils.SessionControl.getSessionFactory;
@Deprecated
public class DataObject {

    SessionFactory sessionFactory = getSessionFactory();
    Session session;

    /*public List<?> selectQuery(HashMap<String, Object> filterParams) {
        startTransaction();
        String sqlString = "from " + getEntityName();
        if (filterParams != null) {
            sqlString += " where " + SqlUtil.getWhereFilter(filterParams);
        }
        List<?> t = session.createQuery(sqlString).list();
        commitTransaction();
    }*/

    public void save() {
        startTransaction();
        session.save(this);
        commitTransaction();
    }

    private void startTransaction() {
        if (session != null && !session.isOpen()) {
            session = sessionFactory.openSession();
            session.beginTransaction();
        }
    }

    private void commitTransaction() {
        if (session != null && session.isOpen()) {
            session.getTransaction().commit();
            session.close();
        }
    }

    private String getEntityName() {
        return this.getClass().getName().replaceAll("(.*)Object(.*)", "");
    }
}
