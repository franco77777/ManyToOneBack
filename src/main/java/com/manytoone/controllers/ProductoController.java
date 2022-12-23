package com.manytoone.controllers;


import com.manytoone.dao.ProductoDao;
import com.manytoone.models.Categoria;
import com.manytoone.models.Producto;
import com.manytoone.services.CategoriaService;
import com.manytoone.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
//@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoDao productoDao;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos(){
        return new ResponseEntity<>(productoDao.findAll(), HttpStatus.OK); //retorna toda la lista con la peticion 200
    };

    @PostMapping("/crear")
    public String crearProducto(@RequestBody Producto producto){
        productoDao.save(producto);
        return "producto creado";
    }

    @PostMapping("/categoria")
    public ResponseEntity<List<Categoria>> listarCategoria(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public  ResponseEntity<Producto> actualizarProducto(@PathVariable Long id,@RequestBody Producto producto){
        Producto productoEncontrado = productoService.findById(id);

        if(productoEncontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try{
            productoEncontrado.setNombre(producto.getNombre());
            productoEncontrado.setPrecio(producto.getPrecio());
            productoEncontrado.setImagen(producto.getImagen());
            productoEncontrado.setCategoria(producto.getCategoria());
            return new ResponseEntity<>(productoService.save(productoEncontrado), HttpStatus.CREATED);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/hola")
    public String saludo(){
        return "hola mundo";
    };
}
