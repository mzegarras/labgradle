package cloud.csonic.labgradle

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/customers"])
class CustomersApi{

    @GetMapping
    fun getCustomers() = "Listado de clientes"

}