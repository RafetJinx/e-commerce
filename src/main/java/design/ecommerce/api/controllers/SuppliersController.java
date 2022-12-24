package design.ecommerce.api.controllers;

import design.ecommerce.business.abstracts.SupplierService;
import design.ecommerce.core.utilities.results.Result;
import design.ecommerce.core.utilities.results.dataResult.DataResult;
import design.ecommerce.entities.concretes.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/suppliers")
public class SuppliersController {
    private SupplierService supplierService;

    @Autowired
    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping(value = "/add")
    Result addSupplier(@RequestBody Supplier supplier){
        return this.supplierService.addSupplier(supplier);
    }

    @GetMapping(value = "/getAll")
    DataResult<List<Supplier>> getAll(){
        return this.supplierService.getAll();
    }

    @GetMapping(value = "/getAllByPage")
    DataResult<List<Supplier>> getAll(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        return this.supplierService.getAll(pageNo, pageSize);
    }

    @GetMapping(value = "/getAllSortedByCompanyNameAsc")
    DataResult<List<Supplier>> getAllSortedByCompanyNameAsc(){
        return this.supplierService.getAllSortedByCompanyNameAsc();
    }

    @GetMapping(value = "/getAllSortedByCompanyNameDesc")
    DataResult<List<Supplier>> getAllSortedByCompanyNameDesc(){
        return this.supplierService.getAllSortedByCompanyNameDesc();
    }

    @GetMapping(value = "/getByCompanyName")
    DataResult<Supplier> getByCompanyName(@RequestParam String companyName){
        return this.supplierService.getByCompanyName(companyName);
    }

    @GetMapping(value = "/getByCompanyNameContains")
    DataResult<List<Supplier>> getByCompanyNameContainsIgnoreCase(@RequestParam String companyName){
        return this.supplierService.getByCompanyNameContainsIgnoreCase(companyName);
    }

    @GetMapping(value = "/getByContactTitle")
    DataResult<Supplier> getByContactTitle(@RequestParam String contactTitle){
        return this.supplierService.getByContactTitle(contactTitle);
    }

    @GetMapping(value = "/getByContactTitleContains")
    DataResult<List<Supplier>> getByContactTitleContainsIgnoreCase(@RequestParam String contactName){
        return this.supplierService.getByContactTitleContainsIgnoreCase(contactName);
    }

    @GetMapping(value = "/getByAddressContains")
    DataResult<List<Supplier>> getByAddressContainsIgnoreCase(@RequestParam String address){
        return this.supplierService.getByAddressContainsIgnoreCase(address);
    }

    @GetMapping(value = "/getByCity")
    DataResult<Supplier> getByCity(@RequestParam String city){
        return this.supplierService.getByCity(city);
    }

    @GetMapping(value = "/getByCityContains")
    DataResult<List<Supplier>> getByCityContainsIgnoreCase(@RequestParam String city){
        return this.supplierService.getByCityContainsIgnoreCase(city);
    }

    @GetMapping(value = "/getByRegion")
    DataResult<Supplier> getByRegion(@RequestParam String region){
        return this.supplierService.getByRegion(region);
    }

    @GetMapping(value = "/getByRegionContains")
    DataResult<List<Supplier>> getByRegionContainsIgnoreCase(@RequestParam String region){
        return this.supplierService.getByRegionContainsIgnoreCase(region);
    }

    @GetMapping(value = "/getByPostalCode")
    DataResult<Supplier> getByPostalCode(@RequestParam String postalCode){
        return this.supplierService.getByPostalCode(postalCode);
    }

    @GetMapping(value = "/getByPostalCodeContains")
    DataResult<List<Supplier>> getByPostalCodeContains(@RequestParam String postalCode){
        return this.supplierService.getByPostalCodeContains(postalCode);
    }

    @GetMapping(value = "/getByCountry")
    DataResult<Supplier> getByCountry(@RequestParam String country){
        return this.supplierService.getByCountry(country);
    }

    @GetMapping(value = "/getByCountryContains")
    DataResult<List<Supplier>> getByCountryContainsIgnoreCase(@RequestParam String country){
        return this.supplierService.getByCountryContainsIgnoreCase(country);
    }

    @GetMapping(value = "/getByPhone")
    DataResult<Supplier> getByPhone(@RequestParam String phone){
        return this.supplierService.getByPhone(phone);
    }

    @GetMapping(value = "/getByFax")
    DataResult<Supplier> getByFax(@RequestParam String fax){
        return this.supplierService.getByFax(fax);
    }

    @GetMapping(value = "/getByHomepage")
    DataResult<Supplier> getByHomepage(@RequestParam String homepage){
        return this.supplierService.getByHomepage(homepage);
    }

    @GetMapping(value = "/getByCityContainsAndCountryContains")
    DataResult<List<Supplier>> getByCityContainsIgnoreCaseAndCountryContainsIgnoreCase
            (@RequestParam("city") String city, @RequestParam("country") String country){
        return this.supplierService.getByCityContainsIgnoreCaseAndCountryContainsIgnoreCase(city, country);
    }

    @GetMapping(value = "/getByCityContainsAndCountryContainsAndRegionContains")
    DataResult<List<Supplier>> getByCityContainsIgnoreCaseAndCountryContainsIgnoreCaseAndRegionContainsIgnoreCase
            (@RequestParam("city") String city,
             @RequestParam("country") String country,
             @RequestParam("country") String region) {
        return this.supplierService.
                getByCityContainsIgnoreCaseAndCountryContainsIgnoreCaseAndRegionContainsIgnoreCase(city, country, region);
    }
}
