package design.ecommerce.business.concretes;

import design.ecommerce.business.abstracts.SupplierService;
import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.core.utilities.results.dataResult.success.SuccessDataResult;
import design.ecommerce.core.utilities.results.successResult.SuccessResult;
import design.ecommerce.dataAccess.abstracts.SupplierDao;
import design.ecommerce.entities.concretes.Supplier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierManager implements SupplierService {
    private SupplierDao supplierDao;

    public SupplierManager(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    @Override
    public Result addSupplier(Supplier supplier) {
        this.supplierDao.save(supplier);
        return new SuccessResult("Tedarikçi Eklendi");
    }

    @Override
    public Result deleteSupplier(Supplier supplier) {
        this.supplierDao.delete(supplier);
        return new SuccessResult("Tedarikçi Silindi");
    }

    @Override
    public DataResult<List<Supplier>> getAll() {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi", this.supplierDao.findAll());
    }

    @Override
    public DataResult<List<Supplier>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Supplier>> getAllSortedByCompanyNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "companyName");
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi", this.supplierDao.findAll(sort));
    }

    @Override
    public DataResult<List<Supplier>> getAllSortedByCompanyNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "companyName");
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi", this.supplierDao.findAll(sort));
    }

    @Override
    public DataResult<Supplier> getByCompanyName(String companyName) {
        return new SuccessDataResult<Supplier>("Tedarikçi Listelendi", this.supplierDao.getByCompanyName(companyName));
    }

    @Override
    public DataResult<List<Supplier>> getByCompanyNameContains(String companyName) {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.getByCompanyNameContains(companyName));
    }

    @Override
    public DataResult<Supplier> getByContactTitle(String contactTitle) {
        return new SuccessDataResult<Supplier>("Tedarikçi Listelendi", this.supplierDao.getByContactTitle(contactTitle));
    }

    @Override
    public DataResult<List<Supplier>> getByContactTitleContains(String contactName) {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.getByContactTitleContains(contactName));
    }

    @Override
    public DataResult<List<Supplier>> getByAddressContains(String address) {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.getByAddressContains(address));
    }

    @Override
    public DataResult<Supplier> getByCity(String city) {
        return new SuccessDataResult<Supplier>("Tedarikçi Listelendi", this.supplierDao.getByCity(city));
    }

    @Override
    public DataResult<List<Supplier>> getByCityContains(String city) {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.getByCityContains(city));
    }

    @Override
    public DataResult<Supplier> getByRegion(String region) {
        return new SuccessDataResult<Supplier>("Tedarikçi Listelendi", this.supplierDao.getByRegion(region));
    }

    @Override
    public DataResult<List<Supplier>> getByRegionContains(String region) {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.getByRegionContains(region));
    }

    @Override
    public DataResult<Supplier> getByPostalCode(String postalCode) {
        return new SuccessDataResult<Supplier>("Tedarikçi Listelendi", this.supplierDao.getByPostalCode(postalCode));
    }

    @Override
    public DataResult<List<Supplier>> getByPostalCodeContains(String postalCode) {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.getByPostalCodeContains(postalCode));
    }

    @Override
    public DataResult<Supplier> getByCountry(String country) {
        return new SuccessDataResult<Supplier>("Tedarikçi Listelendi", this.supplierDao.getByCountry(country));
    }

    @Override
    public DataResult<List<Supplier>> getByCountryContains(String country) {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.getByCountryContains(country));
    }

    @Override
    public DataResult<Supplier> getByPhone(String phone) {
        return new SuccessDataResult<Supplier>("Tedarikçi Listelendi", this.supplierDao.getByPhone(phone));
    }

    @Override
    public DataResult<Supplier> getByFax(String fax) {
        return new SuccessDataResult<Supplier>("Tedarikçi Listelendi", this.supplierDao.getByFax(fax));
    }

    @Override
    public DataResult<Supplier> getByHomepage(String homepage) {
        return new SuccessDataResult<Supplier>("Tedarikçi Listelendi", this.supplierDao.getByHomepage(homepage));
    }

    @Override
    public DataResult<List<Supplier>> getByCityContainsAndCountryContains(String city, String country) {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.getByCityContainsAndCountryContains(city, country));
    }

    @Override
    public DataResult<List<Supplier>> getByCityContainsAndCountryContainsAndRegionContains
            (String city, String county, String region) {
        return new SuccessDataResult<List<Supplier>>("Tedarikçiler Listelendi",
                this.supplierDao.getByCityContainsAndCountryContainsAndRegionContains(city, county, region));
    }
}
