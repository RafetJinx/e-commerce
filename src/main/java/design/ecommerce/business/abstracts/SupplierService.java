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

    DataResult<List<Supplier>> getAllSortedByCompanyNameAsc();
    DataResult<List<Supplier>> getAllSortedByCompanyNameDesc();

    DataResult<Supplier> getByCompanyName(String companyName);
    DataResult<List<Supplier>> getByCompanyNameContainsIgnoreCase(String companyName);

    DataResult<Supplier> getByContactTitle(String contactTitle);
    DataResult<List<Supplier>> getByContactTitleContainsIgnoreCase(String contactName);

    DataResult<List<Supplier>> getByAddressContainsIgnoreCase(String address);

    DataResult<Supplier> getByCity(String city);
    DataResult<List<Supplier>> getByCityContainsIgnoreCase(String city);

    DataResult<Supplier> getByRegion(String region);
    DataResult<List<Supplier>> getByRegionContainsIgnoreCase(String region);

    DataResult<Supplier> getByPostalCode(String postalCode);
    DataResult<List<Supplier>> getByPostalCodeContains(String postalCode);

    DataResult<Supplier> getByCountry(String country);
    DataResult<List<Supplier>> getByCountryContainsIgnoreCase(String country);

    DataResult<Supplier> getByPhone(String phone);

    DataResult<Supplier> getByFax(String fax);

    DataResult<Supplier> getByHomepage(String homepage);

    DataResult<List<Supplier>> getByCityContainsIgnoreCaseAndCountryContainsIgnoreCase(String city, String country);
    DataResult<List<Supplier>> getByCityContainsIgnoreCaseAndCountryContainsIgnoreCaseAndRegionContainsIgnoreCase(String city, String country, String region);
}
