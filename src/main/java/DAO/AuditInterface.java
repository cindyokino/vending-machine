
package DAO;

import DTO.Product;

/**
 *
 * @author W
 */
public interface AuditInterface {
    void recordProduct(Product soldProduct) throws CannotOpenFile;
}
