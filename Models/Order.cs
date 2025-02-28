
using System.ComponentModel.DataAnnotations;

public class Order {
    public int OrderID { get; set; }
    [Required(ErrorMessage = "User ID is required")]
    public int UserID { get; set; }
    public DateTime OrderDate { get; set; } = DateTime.Now;
    [Required(ErrorMessage = "Status is required")]
    public string Status { get; set; } = "Pending";
}