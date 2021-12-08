package duran.rutilio.bottomnavreto.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import duran.rutilio.bottomnavreto.databinding.FragmentDashboardBinding
import android.webkit.WebViewClient




class DashboardFragment : Fragment() {

  private lateinit var dashboardViewModel: DashboardViewModel
private var _binding: FragmentDashboardBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val mybtn: Button = binding.btnIr
    val mytxt: TextView = binding.textoIr

    val myWebView: WebView = binding.webv
      myWebView.setWebViewClient(object : WebViewClient() {
          override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
              return false
          }
      })
    myWebView.loadUrl("https://www.google.com")


      mybtn.setOnClickListener{
          myWebView.loadUrl("https://www.google.com/search?q="+mytxt.text.toString())
      }

//    val textView: TextView = binding.textDashboard
//    dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//      textView.text = it
//    })
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}