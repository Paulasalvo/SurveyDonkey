package com.desafiolatam.surveydonkey.ui.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.desafiolatam.surveydonkey.databinding.FragmentEndBinding
import com.desafiolatam.surveydonkey.viewmodel.MainViewModel

class EndFragment : Fragment() {

    private var _binding: FragmentEndBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEndBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("EndQuestion", "EndQuestion onViewCreated")
        if (ContextCompat.checkSelfPermission(this.requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Permiso no otorgado, solicitarlo al usuario
            ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 100)
        } else {
            Toast.makeText(requireContext(),"Permisos de guardado otorgado",Toast.LENGTH_SHORT).show()
            // El permiso ya está otorgado, puedes realizar las operaciones de escritura de archivos
        }
        binding.tvFirstAnswer.text = viewModel.getFirstResult()
        binding.tvSecondAnswer.text = viewModel.getSecondResult()
        binding.tvThirdQuestion.text = viewModel.getThirdResult()
        binding.tvUserEmail.text = viewModel.getUserEmail()
        binding.tvUserSuggest.text = viewModel.getUserSuggest()
    }

    override fun onResume() {
        super.onResume()
        binding.tvFirstAnswer.text = viewModel.getFirstResult()
        binding.tvSecondAnswer.text = viewModel.getSecondResult()
        binding.tvThirdQuestion.text = viewModel.getThirdResult()
        binding.tvUserEmail.text = viewModel.getUserEmail()
        binding.tvUserSuggest.text = viewModel.getUserSuggest()
    }

    override fun onPause() {
        super.onPause()
        binding.tvFirstAnswer.text = viewModel.getFirstResult()
        binding.tvSecondAnswer.text = viewModel.getSecondResult()
        binding.tvThirdQuestion.text = viewModel.getThirdResult()
        binding.tvUserEmail.text = viewModel.getUserEmail()
        binding.tvUserSuggest.text = viewModel.getUserSuggest()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("EndQuestion", "EndQuestion onDestroy")
    }

}