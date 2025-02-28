
using System.ComponentModel.DataAnnotations;

public class OrderDetails {
    public int OrderDetailID { get; set; }
    [Required(ErrorMessage = "Order ID is required")]
    public int OrderID { get; set; }
    [Required(ErrorMessage = "Product ID is required")]
    public int ProductID { get; set; }
    [Required(ErrorMessage = "Quantity is required")]
    [Range(1, int.MaxValue, ErrorMessage = "Quantity must be at least 1")]
    public int Quantity { get; set; }
    public decimal SubTotal { get; set; }
}