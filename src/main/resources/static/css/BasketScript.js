// Calculate and display the subtotal price
function updateSubtotal() {
    let subtotalPrice = 0;
    const productTotalElements = document.querySelectorAll('.product-total');
    productTotalElements.forEach((productTotalElement) => {
      const price = parseFloat(productTotalElement.textContent.replace('£', ''));
      subtotalPrice += price;
    });
    const subtotalElement = document.querySelector('.subtotal-price');
    subtotalElement.textContent = `£${subtotalPrice.toFixed(2)}`;
  }
  
  // Calculate and display the discount price
  function updateDiscount() {
    const subtotal = parseFloat(document.querySelector('.subtotal-price').textContent.replace('£', ''));
    const discount = 0.1; // 10% discount
    const discountPrice = subtotal * discount;
    const discountElement = document.querySelector('.discount-price');
    discountElement.textContent = `£${discountPrice.toFixed(2)}`;
  }
  
  // Calculate and display the total price
  function updateTotal() {
    const subtotal = parseFloat(document.querySelector('.subtotal-price').textContent.replace('£', ''));
    const discount = parseFloat(document.querySelector('.discount-price').textContent.replace('£', ''));
    const totalPrice = subtotal - discount;
    const totalElement = document.querySelector('.total-price');
    totalElement.textContent = `£${totalPrice.toFixed(2)}`;
  }
  
  // Update quantity display when plus or minus button is clicked
  const quantityBtns = document.querySelectorAll('.quantity-btn');
  quantityBtns.forEach(btn => {
    btn.addEventListener('click', () => {
      const quantityDisplay = btn.parentNode.querySelector('.quantity');
      let quantity = parseInt(quantityDisplay.textContent);
      if (btn.classList.contains('plus-btn')) {
        quantity++;
      } else if (btn.classList.contains('minus-btn')) {
        if (quantity > 1) {
          quantity--;
        }
      }
      quantityDisplay.textContent = quantity;
  
      // Update product total
      const priceElement = btn.parentNode.previousElementSibling;
      const price = parseFloat(priceElement.textContent.replace('£', ''));
      const productTotalElement = btn.parentNode.nextElementSibling;
      const productTotal = price * quantity;
      productTotalElement.textContent = `£${productTotal.toFixed(2)}`;
  
      // Update subtotal, discount, and total
      updateSubtotal();
      updateDiscount();
      updateTotal();
    });
  });
  
  // Remove product from basket when remove button is clicked
  const removeButtons = document.querySelectorAll('.remove-btn');
  removeButtons.forEach(button => {
    button.addEventListener('click', () => {
      const row = button.closest('tr');
      row.remove();
  
      // Update subtotal, discount, and total
      updateSubtotal();
      updateDiscount();
      updateTotal();
  
      showEmptyMessage();
    });
  });
  
  // Show empty message if basket is empty
  function showEmptyMessage() {
    const basket = document.querySelector('.basket');
    const emptyMessage = document.querySelector('.empty-message');
    if (basket.rows.length <= 1) {
      emptyMessage.style.display = 'block';
    } else {
      emptyMessage.style.display = 'none';
    }
  }
  
  updateSubtotal();
  updateDiscount();
  updateTotal();
  showEmptyMessage();
  