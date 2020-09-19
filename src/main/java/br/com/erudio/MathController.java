package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.util.NumberConverter;
import br.com.erudio.util.SimpleMath;

@RestController
public class MathController {

	private SimpleMath math = new SimpleMath();

	@RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double firstNumber = NumberConverter.convertToDouble(numberOne);
		Double secondNumber = NumberConverter.convertToDouble(numberTwo);

		return math.sum(firstNumber, secondNumber);
	}

	@RequestMapping(value = "sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double firstNumber = NumberConverter.convertToDouble(numberOne);
		Double secondNumber = NumberConverter.convertToDouble(numberTwo);

		return math.sub(firstNumber, secondNumber);
	}

	@RequestMapping(value = "mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double firstNumber = NumberConverter.convertToDouble(numberOne);
		Double secondNumber = NumberConverter.convertToDouble(numberTwo);

		return math.mult(firstNumber, secondNumber);
	}

	@RequestMapping(value = "div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double firstNumber = NumberConverter.convertToDouble(numberOne);
		Double secondNumber = NumberConverter.convertToDouble(numberTwo);

		return math.div(firstNumber, secondNumber);
	}

	@RequestMapping(value = "avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double firstNumber = NumberConverter.convertToDouble(numberOne);
		Double secondNumber = NumberConverter.convertToDouble(numberTwo);

		return math.avg(firstNumber, secondNumber);
	}

	@RequestMapping(value = "sqrt/{numberOne}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {

		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}

		Double firstNumber = NumberConverter.convertToDouble(numberOne);

		return math.sqrt(firstNumber);
	}
}
