window.onload=function(){
    const sliderWrapper = document.querySelector(".slider-wrapper");
    const sliderButtonLeft = document.querySelector(".slider-button-left");
    const sliderButtonRight = document.querySelector(".slider-button-right");
    const sliderItemWidth = document.querySelector(".slider-item").offsetWidth;
    let sliderPosition = 0;
    
    sliderButtonLeft.addEventListener("click", () => {
      if (sliderPosition !== 0) {
        sliderPosition += sliderItemWidth * 3;
        sliderWrapper.style.transform = `translateX(${sliderPosition}px)`;
      }
    });
    
    sliderButtonRight.addEventListener("click", () => {
      if (sliderPosition !== -(sliderItemWidth * 6)) {
        sliderPosition -= sliderItemWidth * 3;
        sliderWrapper.style.transform = `translateX(${sliderPosition}px)`;
      }
    });
  }