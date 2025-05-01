package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

	//	フォーム画面を読み込む時の表示
	@GetMapping("/form")
	public String viewForm(Model model) {
	    if (!model.containsAttribute("contactForm")) {
	        model.addAttribute("contactForm", new ContactForm());
	    }
	    return "contactFormView";
	}

	//	フォーム画面からデータが送信されてきたときの表示
	@PostMapping("/confirm")
	public String confirmForm(
			@Validated @ModelAttribute("contactForm") ContactForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model) {

		if (result.hasErrors()) {

			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX +
					Conventions.getVariableName(form), result);
			redirectAttributes.addFlashAttribute("contactForm", form);

			return "redirect:/form";

		}

		model.addAttribute("contactForm", form);

		return "confirmView";
	}

}
