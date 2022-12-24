package design.ecommerce.dataAccess.abstracts;

import design.ecommerce.entities.concretes.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer> {

    @Transactional
    Integer deleteBySupplierId(int supplierId);

    Supplier getByCompanyName(String companyName);
    List<Supplier> getByCompanyNameContainsIgnoreCase(String companyName);

    Supplier getByContactName(String contactName);
    List<Supplier> getByContactNameContainsIgnoreCase(String contactName);

    Supplier getByContactTitle(String contactTitle);
    List<Supplier> getByContactTitleContainsIgnoreCase(String contactName);

    List<Supplier> getByAddressContainsIgnoreCase(String address);

    Supplier getByCity(String city);
    List<Supplier> getByCityContainsIgnoreCase(String city);

    Supplier getByRegion(String region);
    List<Supplier> getByRegionContainsIgnoreCase(String region);

    Supplier getByPostalCode(String postalCode);
    List<Supplier> getByPostalCodeContains(String postalCode);

    Supplier getByCountry(String country);
    List<Supplier> getByCountryContainsIgnoreCase(String country);

    Supplier getByPhone(String phone);

    Supplier getByFax(String fax);

    Supplier getByHomepage(String homepage);

    List<Supplier> getByCityContainsIgnoreCaseAndCountryContainsIgnoreCase(String city, String country);
    List<Supplier> getByCityContainsIgnoreCaseAndCountryContainsIgnoreCaseAndRegionContainsIgnoreCase(String city, String county, String region);

//    SELECT COUNT(p.product_id), s.company_name
//    FROM suppliers as s
//    INNER JOIN products as p
//    ON s.supplier_id = p.supplier_id
//    GROUP BY s.company_name
}
