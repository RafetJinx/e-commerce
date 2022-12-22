package design.ecommerce.dataAccess.abstracts;

import design.ecommerce.entities.concretes.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierDao extends JpaRepository<Supplier, Integer> {

    Supplier getByCompanyName(String companyName);
    List<Supplier> getByCompanyNameContains(String companyName);

    Supplier getByContactName(String contactName);
    List<Supplier> getByContactNameContains(String contactName);

    Supplier getByContactTitle(String contactTitle);
    List<Supplier> getByContactTitleContains(String contactName);

    List<Supplier> getByAddressContains(String address);

    Supplier getByCity(String city);
    List<Supplier> getByCityContains(String city);

    Supplier getByRegion(String region);
    List<Supplier> getByRegionContains(String region);

    Supplier getByPostalCode(String postalCode);
    List<Supplier> getByPostalCodeContains(String postalCode);

    Supplier getByCountry(String country);
    List<Supplier> getByCountryContains(String country);

    Supplier getByPhone(String phone);

    Supplier getByFax(String fax);

    Supplier getByHomepage(String homepage);

    List<Supplier> getByCityContainsAndCountryContains(String city, String country);
    List<Supplier> getByCityContainsAndCountryContainsAndRegionContains(String city, String county, String region);

//    SELECT COUNT(p.product_id), s.company_name
//    FROM suppliers as s
//    INNER JOIN products as p
//    ON s.supplier_id = p.supplier_id
//    GROUP BY s.company_name
}
