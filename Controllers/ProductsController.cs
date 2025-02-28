
using Microsoft.AspNetCore.Mvc;
using AmazonSa.Models;
using System.Collections.Generic;
[Route("Products")]
public class ProductsController : Controller {
    // Dummy data for demonstration
    private List<Product> _products = new List<Product> {
        new Product { ProductID = 1, Name = "Laptop", Category = "Electronics", Price = 1200, StockQuantity = 10 },
        new Product { ProductID = 2, Name = "T-Shirt", Category = "Clothing", Price = 20, StockQuantity = 50 }
    };

    // GET: /Products
    [HttpGet]
    public IActionResult Index() {
        return View(_products);
    }
}