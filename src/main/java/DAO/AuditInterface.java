package DAO;

import DTO.Product;

public interface AuditInterface {
    void recordProduct(int soldProduct) throws CannotOpenFile;    
}
