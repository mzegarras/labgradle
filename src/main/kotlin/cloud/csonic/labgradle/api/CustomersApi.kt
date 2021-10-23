package cloud.csonic.labgradle.api

import cloud.csonic.labgradle.api.dto.CustomerDto
import cloud.csonic.labgradle.api.dto.CustomersDto
import cloud.csonic.labgradle.service.CustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/customers"])
class CustomersApi(val customerService: CustomerService){

    @GetMapping
    fun getAll() = CustomersDto(customerService.findAll())

    @GetMapping("{id}")
    fun getById(@PathVariable("id") id:Long) = CustomerDto(customerService.findById(id))

}