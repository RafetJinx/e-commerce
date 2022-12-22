package design.ecommerce.business.abstracts;

import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.entities.concretes.Supplier;

import java.util.List;

public interface SupplierService {
    Result addSupplier(Supplier supplier);
    Result deleteSupplier(Supplier supplier);

    DataResult<List<Supplier>> getAll();
    //Pagination function
    DataResult<List<Supplier>> getAll(int pageNo, int pageSize);

    DataResult<List<Supplier>> getAllSortedBySupplierNameAsc();
    DataResult<List<Supplier>> getAllSortedBySupplierNameDesc();

    DataResult<Supplier> getByCompanyName(String companyName);
    DataResult<List<Supplier>> getByCompanyNameContains(String companyName);

    DataResult<Supplier> getByContactTitle(String contactTitle);
    DataResult<List<Supplier>> getByContactTitleContains(String contactName);

    DataResult<List<Supplier>> getByAddressContains(String address);

    DataResult<Supplier> getByCity(String city);
    DataResult<List<Supplier>> getByCityContains(String city);

    DataResult<Supplier> getByRegion(String region);
    DataResult<List<Supplier>> getByRegionContains(String region);

    DataResult<Supplier> getByPostalCode(String postalCode);
    DataResult<List<Supplier>> getByPostalCodeContains(String postalCode);

    DataResult<Supplier> getByCountry(String country);
    DataResult<List<Supplier>> getByCountryContains(String country);

    DataResult<Supplier> getByPhone(String phone);

    DataResult<Supplier> getByFax(String fax);

    DataResult<Supplier> getByHomepage(String homepage);

    DataResult<List<Supplier>> getByCityContainsAndCountryContains(String city, String country);
    DataResult<List<Supplier>> getByCityContainsAndCountryContainsAndRegionContains(String city, String county, String region);
}
