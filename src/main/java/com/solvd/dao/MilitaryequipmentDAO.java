package com.solvd.dao;

import com.solvd.configuration.AbstractDAO;
import com.solvd.dao.interfaces.IMilitaryequipmentDAO;
import com.solvd.model.MilitaryequipmentModel;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class MilitaryequipmentDAO extends AbstractDAO implements IMilitaryequipmentDAO {
        private static final Logger LOGGER = Logger.getLogger(MilitaryequipmentDAO.class);

        @Override
        public List<MilitaryequipmentModel> getAllMilitaryequipments() {
            List<MilitaryequipmentModel> allMilitaryequipments = new ArrayList<>();
            try {
                getResultSet("SELECT * FROM bloshkoarmy.militaryequipment;");
                while (resultSet.next()) {
                    MilitaryequipmentModel militaryequipment = new MilitaryequipmentModel();
                    militaryequipment.setIdMilitaryequipment(resultSet.getInt("idMilitaryequipment"));
                    militaryequipment.setNameEquipment(resultSet.getString("nameEquipment"));
                    militaryequipment.setQuantityEquipment(resultSet.getInt("quantityEquipment"));
                    militaryequipment.setClassEquipment(resultSet.getString("classEquipment"));
                    militaryequipment.setArmyIdarmy(resultSet.getInt("armyIdarmy"));
                    allMilitaryequipments.add(militaryequipment);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeALL();
            }
            return allMilitaryequipments;
        }

    }

