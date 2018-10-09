package com.vn.osp.notarialservices.contracttemplate.repository;

import com.vn.osp.notarialservices.contracttemplate.domain.PrivyTemplateBO;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 8/11/2017.
 */
@Component
public class PrivyTemplateRepositoryImpl implements PrivyTemplateRepositoryCustom  {
    private static final Logger LOG = Logger.getLogger(PropertyTemplateRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    public PrivyTemplateRepositoryImpl(JpaContext context) {
        Assert.notNull(context, "JpaContext must not be null!");
    }

    @Override
    public Optional<List<PrivyTemplateBO>> list() {
        try {
            List<PrivyTemplateBO> list=entityManager.createQuery("select pr from PrivyTemplateBO pr ORDER BY entry_time DESC",PrivyTemplateBO.class).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.list():"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PrivyTemplateBO>());
        }
    }

    @Override
    public Optional<List<PrivyTemplateBO>> listItemPage(int offset, int number) {
        try {
            List<PrivyTemplateBO> list=entityManager.createQuery("select pr from PrivyTemplateBO pr ORDER BY entry_time DESC",
                    PrivyTemplateBO.class).setFirstResult(offset).setMaxResults(number).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method PropertyTemplateRepositoryImpl.listItemPage():"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PrivyTemplateBO>());
        }
    }
    @Override
    public Optional<List<PrivyTemplateBO>> listItemPageByType(String type, int offset, int number) {
        try {
            List<PrivyTemplateBO> list=entityManager.createQuery("select pr from PrivyTemplateBO pr where pr.type=:type ORDER BY entry_time DESC",
                    PrivyTemplateBO.class).setParameter("type", type).setFirstResult(offset).setMaxResults(number).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.listItemPage():"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PrivyTemplateBO>());
        }
    }

    @Override
    public Optional<List<PrivyTemplateBO>> getByType(String type) {
        try {
            List<PrivyTemplateBO> list=entityManager.createQuery("select pr from PrivyTemplateBO pr where pr.type = :type ORDER BY entry_time",
                    PrivyTemplateBO.class).setParameter("type", type).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.getByType():"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PrivyTemplateBO>());
        }
    }

    @Override
    public Optional<List<PrivyTemplateBO>> getByName(String type) {
        try {
            List<PrivyTemplateBO> list=entityManager.createQuery("select pr from PrivyTemplateBO pr where pr.name = :type ORDER BY entry_time",
                    PrivyTemplateBO.class).setParameter("type", type).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.getByType():"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PrivyTemplateBO>());
        }
    }

    @Override
    public Optional<List<PrivyTemplateBO>> getByCode(String code) {
        try {
            List<PrivyTemplateBO> list=entityManager.createQuery("select pr from PrivyTemplateBO pr where pr.code = :code ORDER BY entry_time",
                    PrivyTemplateBO.class).setParameter("code", code).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.getByType():"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PrivyTemplateBO>());
        }
    }

    @Override
    public Optional<Long> countByType(String type) {
        try {
            long count=(long)entityManager.createQuery("select count(pr.id) from PrivyTemplateBO pr where pr.type = :type").setParameter("type", type).getSingleResult();
            return Optional.ofNullable(count);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.countByType():"+e.getMessage());
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Optional<Long> total() {
        try {
            long count=(long)entityManager.createQuery("select count(pr.id) from PrivyTemplateBO pr").getSingleResult();
            return Optional.ofNullable(count);
        } catch (Exception e) {
            LOG.error("Have an error in method PropertyTemplateRepositoryImpl.countByType():"+e.getMessage());
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Optional<PrivyTemplateBO> getById(int id) {
        try {
            PrivyTemplateBO item=entityManager.find(PrivyTemplateBO.class,id);
            return Optional.ofNullable(item);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.getById():"+e.getMessage());
            return Optional.ofNullable(new PrivyTemplateBO());
        }
    }

    @Override
    public Optional<Boolean> add(PrivyTemplateBO item) {
        try {
            item.setId(0);
            entityManager.persist(item);
            entityManager.flush();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.add():"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Optional<Boolean> update(PrivyTemplateBO item) {
        try {
            PrivyTemplateBO itemDB=entityManager.find(PrivyTemplateBO.class,item.getId());
            itemDB.setName(item.getName());
            itemDB.setDescription(item.getDescription());
            itemDB.setHtml(item.getHtml());
            itemDB.setUpdate_user(item.getUpdate_user());
            itemDB.setUpdate_time(item.getUpdate_time());
            itemDB.setDisable(item.isDisable());
            itemDB.setType(item.getType());
            entityManager.merge(itemDB);
            entityManager.flush();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method PropertyTemplateRepositoryImpl.update():"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Boolean deleteItem(int id) {
        try {
            PrivyTemplateBO item=entityManager.find(PrivyTemplateBO.class,id);
            if(item!=null){
                entityManager.remove(item);
            }
            return Boolean.valueOf(true);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.delete():"+e.getMessage());
            return Boolean.valueOf(false);
        }
    }

//    public static void main(String[] args) throws IOException {
//        String excelFilePath = "E:/test.xlsx";
//        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
//
//        Workbook workbook = new XSSFWorkbook(inputStream);
//        Sheet firstSheet = workbook.getSheetAt(0);
//        Iterator<Row> iterator = firstSheet.iterator();
//
//        while (iterator.hasNext()) {
//            Row nextRow = iterator.next();
//            Iterator<Cell> cellIterator = nextRow.cellIterator();
//
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//
//                switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue());
//                        break;
//                    case Cell.CELL_TYPE_BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        break;
//                }
//                System.out.print(" - ");
//            }
//            //System.out.println();
//        }
//
//        workbook.close();
//        inputStream.close();
//    }

}
