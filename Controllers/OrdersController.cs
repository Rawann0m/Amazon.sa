
using Microsoft.AspNetCore.Mvc;
using AmazonSa.Models;
using System.Collections.Generic;
[Route("Orders")]
public class OrdersController : Controller
{
    // Dummy data for demonstration
    private List<Order> _orders = new List<Order> {
    new Order { OrderID = 1, UserID = 1, Status = "Completed" },
    new Order { OrderID = 2, UserID = 1, Status = "Pending" },
    new Order { OrderID = 3, UserID = 2, Status = "Completed" }
};
    private List<OrderDetails> _orderDetails = new List<OrderDetails>();
    private List<Product> _products = new List<Product> {
        new Product { ProductID = 1, Name = "Laptop", Category = "Electronics", Price = 1200, StockQuantity = 10 },
        new Product { ProductID = 2, Name = "T-Shirt", Category = "Clothing", Price = 20, StockQuantity = 50 }
    };

    // GET: /Orders/{userId}
    [HttpGet("{userId}")]
    public IActionResult OrderHistory(int userId)
    {
        Console.WriteLine($"Fetching orders for UserID: {userId}");
        var userOrders = _orders.FindAll(o => o.UserID == userId);
        Console.WriteLine($"Found {userOrders.Count} orders");
        return View(userOrders);
    }

    // GET: /Orders/PlaceOrder
    [HttpGet("Orders/PlaceOrder")]
    public IActionResult PlaceOrder()
    {
        ViewBag.Products = _products;
        return View();
    }

    // POST: /Orders/PlaceOrder
    [HttpPost("Orders/PlaceOrder")]
    public IActionResult PlaceOrder(int userId, int productId, int quantity)
    {
        var product = _products.Find(p => p.ProductID == productId);
        if (product == null || product.StockQuantity < quantity)
        {
            ModelState.AddModelError("", "Product not available or insufficient stock.");
            ViewBag.Products = _products;
            return View();
        }

        // Create order
        var order = new Order
        {
            UserID = userId,
            Status = "Pending"
        };
        _orders.Add(order);

        // Create order details
        var orderDetail = new OrderDetails
        {
            OrderID = order.OrderID,
            ProductID = productId,
            Quantity = quantity,
            SubTotal = product.Price * quantity
        };
        _orderDetails.Add(orderDetail);

        // Update stock
        product.StockQuantity -= quantity;

        return RedirectToAction("OrderHistory", new { userId = userId });
    }
}