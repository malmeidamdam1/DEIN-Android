import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.menu_bottom.R

class PageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_page, container, false)
        val icon = arguments?.getInt(ARG_ICON, 0) ?: 0
        layout.findViewById<View>(R.id.imageView).setBackgroundResource(icon)
        return layout
    }

    companion object {
        private const val ARG_ICON = "ARG_ICON"
        fun newInstance(@DrawableRes iconId: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt(ARG_ICON, iconId)
            fragment.arguments = args
            return fragment
        }
    }




}