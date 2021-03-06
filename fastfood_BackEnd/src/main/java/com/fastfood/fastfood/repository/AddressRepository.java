package com.fastfood.fastfood.repository;
import com.fastfood.fastfood.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    //	To check if the address table is empty
    @Query("SELECT count(a) from Address a")
    public Long getCountOfAddress();

    // To find the maximum addressId in the address table to add a new address with addressId next to the max id
    @Query("SELECT max(a.addressId) from Address a")
    public int getMaxOfAddressId();

}